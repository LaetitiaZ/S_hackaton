package hackaton;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.mean;
import static org.apache.spark.sql.functions.stddev_pop;


public class Convert {

	
	public static void main(String[] args) 
	{
		
		
		SparkSession spark =  SparkSession //create a spark session
		      .builder()
		      .master("local")
		      .appName("Hackaton")
		      .config("spark.some.config.option", "some-value")
		      .getOrCreate();
		
		runSession(spark);
		
	}
	
	
	public static void runSession(SparkSession spark) 
	{
		try {
		Dataset<Row> initialSet = spark.read().format("csv")
				.option("header","true") 	//consider the first line of csv as header to the dataset
				.load("src/main/resources/winemag-data-130k-v2.csv");
	
		
		//show 20 first rows of the dataset
		initialSet.show(); 
		
		//Copy of the dataset in an ORC file called wineDataSet.orc into tmp folder in the local disk
		initialSet.write().format("orc").mode(SaveMode.Overwrite).save("/tmp/orc/wineDataSet.orc"); 
		
		//define a dataset loaded from the ORC file
		Dataset<Row> orcSet = spark.read().format("orc")  
				//Delete the header
				.option("header","false")				
				.load("/tmp/orc/wineDataSet.orc");
		
		
		//define id, points and price as columns
		Column id =orcSet.col("id");
		Column points= orcSet.col("points");
		Column price = orcSet.col("price");
		
		//creation of the cleaned dataset
		Dataset<Row> cleanSet = orcSet.select(id,points,price);
		
		cleanSet.show();
		
		//save cleanSet into another ORC file named reducedDataSet
		 cleanSet.write().format("orc").mode(SaveMode.Overwrite).save("/tmp/orc/reducedDataSet.orc");
		
	
		//display the set aggregated by country with average of points and standard deviation
		Dataset<Row> aggSet = orcSet.groupBy("country").agg(stddev_pop("points"),mean("points"));
		
		aggSet.show();
		
		//create table named test from orcSet
		orcSet.registerTempTable("test");
		
		
		//display top 5 best wines below 10 USD
		spark.sql("SELECT * FROM test WHERE price<=10 ORDER BY points DESC").show(5);

		//display  top 5 best wines below 30 USD from Chile
		spark.sql("SELECT * FROM test WHERE price<=30 AND country='Chile' ORDER BY points DESC").show(5);
			
		Dataset<Row> versus = cleanSet.groupBy("price").agg(mean("points"));
		
		//display visualization price versus points : average price for a bottle depending on the rate
		versus.show();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}		
	
}
