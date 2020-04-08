/* The program is a maven project which uses JAVA language and was written on Eclipse IDE

Spark Apache library is used for datasets. 

Here is an extract of what returns the program after being executed : 

//display of the dataset loaded from csv file using show() method (which is the same for orc file)
+---+---------+--------------------+--------------------+------+-----+-----------------+-------------------+-----------------+------------------+---------------------+--------------------+------------------+-------------------+
| id|  country|         description|         designation|points|price|         province|           region_1|         region_2|       taster_name|taster_twitter_handle|               title|           variety|             winery|
+---+---------+--------------------+--------------------+------+-----+-----------------+-------------------+-----------------+------------------+---------------------+--------------------+------------------+-------------------+
|  0|    Italy|Aromas include tr...|        Vulkà Bianco|    87| null|Sicily & Sardinia|               Etna|             null|     Kerin O’Keefe|         @kerinokeefe|Nicosia 2013 Vulk...|       White Blend|            Nicosia|
|  1| Portugal|This is ripe and ...|            Avidagos|    87| 15.0|            Douro|               null|             null|        Roger Voss|           @vossroger|Quinta dos Avidag...|    Portuguese Red|Quinta dos Avidagos|
|  2|       US|Tart and snappy, ...|                null|    87| 14.0|           Oregon|  Willamette Valley|Willamette Valley|      Paul Gregutt|          @paulgwine |Rainstorm 2013 Pi...|        Pinot Gris|          Rainstorm|
|  3|       US|Pineapple rind, l...|Reserve Late Harvest|    87| 13.0|         Michigan|Lake Michigan Shore|             null|Alexander Peartree|                 null|St. Julian 2013 R...|          Riesling|         St. Julian|
|  4|       US|Much like the reg...|Vintner's Reserve...|    87| 65.0|           Oregon|  Willamette Valley|Willamette Valley|      Paul Gregutt|          @paulgwine |Sweet Cheeks 2012...|        Pinot Noir|       Sweet Cheeks|
|  5|    Spain|Blackberry and ra...|        Ars In Vitro|    87| 15.0|   Northern Spain|            Navarra|             null| Michael Schachner|          @wineschach|Tandem 2011 Ars I...|Tempranillo-Merlot|             Tandem|
|  6|    Italy|Here's a bright, ...|             Belsito|    87| 16.0|Sicily & Sardinia|           Vittoria|             null|     Kerin O’Keefe|         @kerinokeefe|Terre di Giurfo 2...|          Frappato|    Terre di Giurfo|
|  7|   France|This dry and rest...|                null|    87| 24.0|           Alsace|             Alsace|             null|        Roger Voss|           @vossroger|Trimbach 2012 Gew...|    Gewürztraminer|           Trimbach|
|  8|  Germany|Savory dried thym...|               Shine|    87| 12.0|      Rheinhessen|               null|             null|Anna Lee C. Iijima|                 null|Heinz Eifel 2013 ...|    Gewürztraminer|        Heinz Eifel|
|  9|   France|This has great de...|         Les Natures|    87| 27.0|           Alsace|             Alsace|             null|        Roger Voss|           @vossroger|Jean-Baptiste Ada...|        Pinot Gris| Jean-Baptiste Adam|
| 10|       US|Soft, supple plum...|      Mountain Cuvée|    87| 19.0|       California|        Napa Valley|             Napa|    Virginie Boone|              @vboone|Kirkland Signatur...|Cabernet Sauvignon| Kirkland Signature|
| 11|   France|This is a dry win...|                null|    87| 30.0|           Alsace|             Alsace|             null|        Roger Voss|           @vossroger|Leon Beyer 2012 G...|    Gewürztraminer|         Leon Beyer|
| 12|       US|Slightly reduced,...|                null|    87| 34.0|       California|   Alexander Valley|           Sonoma|    Virginie Boone|              @vboone|Louis M. Martini ...|Cabernet Sauvignon|   Louis M. Martini|
| 13|    Italy|This is dominated...|               Rosso|    87| null|Sicily & Sardinia|               Etna|             null|     Kerin O’Keefe|         @kerinokeefe|Masseria Settepor...| Nerello Mascalese|Masseria Setteporte|
| 14|       US|Building on 150 y...|                null|    87| 12.0|       California|      Central Coast|    Central Coast|     Matt Kettmann|        @mattkettmann|Mirassou 2012 Cha...|        Chardonnay|           Mirassou|
| 15|  Germany|Zesty orange peel...|               Devon|    87| 24.0|            Mosel|               null|             null|Anna Lee C. Iijima|                 null|Richard Böcking 2...|          Riesling|    Richard Böcking|
| 16|Argentina|Baked plum, molas...|               Felix|    87| 30.0|            Other|           Cafayate|             null| Michael Schachner|          @wineschach|Felix Lavaque 201...|            Malbec|      Felix Lavaque|
| 17|Argentina|Raw black-cherry ...| Winemaker Selection|    87| 13.0| Mendoza Province|            Mendoza|             null| Michael Schachner|          @wineschach|Gaucho Andino 201...|            Malbec|      Gaucho Andino|
| 18|    Spain|Desiccated blackb...|Vendimia Seleccio...|    87| 28.0|   Northern Spain|   Ribera del Duero|             null| Michael Schachner|          @wineschach|Pradorey 2010 Ven...| Tempranillo Blend|           Pradorey|
| 19|       US|Red fruit aromas ...|                null|    87| 32.0|         Virginia|           Virginia|             null|Alexander Peartree|                 null|Quiévremont 2012 ...|          Meritage|        Quiévremont|
+---+---------+--------------------+--------------------+------+-----+-----------------+-------------------+-----------------+------------------+---------------------+--------------------+------------------+-------------------+
only showing top 20 rows

...
...

//display of 5 best wines under 10$ from Chile
+-----+-------+--------------------+--------------------+------+-----+----------------+--------+--------+-----------------+---------------------+--------------------+------------------+-----------------+
|   id|country|         description|         designation|points|price|        province|region_1|region_2|      taster_name|taster_twitter_handle|               title|           variety|       winery;;;;|
+-----+-------+--------------------+--------------------+------+-----+----------------+--------+--------+-----------------+---------------------+--------------------+------------------+-----------------+
| 1366|  Chile|Lavender and lico...|             Reserve|    87|  9.0|    Maipo Valley|    null|    null|Michael Schachner|          @wineschach|Santa Alicia 2006...|Cabernet Sauvignon|  Santa Alicia;;;|
| 2854|  Chile|Earthy plum and b...|Elegido Gran Reserva|    88| 18.0|Colchagua Valley|    null|    null|Michael Schachner|          @wineschach|Valle Hermoso 201...|            Malbec|Valle Hermoso;;;;|
| 3747|  Chile|Cherry and raspbe...|                Alba|    86|  8.0|  Central Valley|    null|    null|Michael Schachner|          @wineschach|Santa Luz 2014 Al...|Cabernet Sauvignon|    Santa Luz;;;;|
| 6558|  Chile|A pink-meets-tan ...|             Reserva|    85| 12.0|    Maule Valley|    null|    null|Michael Schachner|          @wineschach|Sierra Batuco 201...|      Pinot Grigio|Sierra Batuco;;;;|
|14436|  Chile|Simple aromas of ...|      Classic Series|    86| 13.0| Aconcagua Costa|    null|    null|Michael Schachner|          @wineschach|Montes 2015 Class...|   Sauvignon Blanc|       Montes;;;;|
+-----+-------+--------------------+--------------------+------+-----+----------------+--------+--------+-----------------+---------------------+--------------------+------------------+-----------------+
only showing top 5 rows

*/
