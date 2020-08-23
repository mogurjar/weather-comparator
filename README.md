# weather-comparator

This test project is used to compare weather details(Temperature in Degrees) from UI(NDTV Website) 
and API(OpenWeatherMap)

Test can be configured from src/test/resources/config.properties for City, APIKey, Variance factor in 
degree for comparision of temperature.

This Project is a maven build and can be executed by running goal mvn clean test
Report after maven build can be found at target/surefire-reports/Weather Comparision/test.html

Also This can be executed by running TestNG.xml from IDE.
For this reports can be found at test-output/emailable-report.html