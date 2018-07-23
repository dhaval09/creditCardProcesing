# creditCardProcesing
This is a simple Application for Basic Credit Card Processing. 

This application can accept input from command line or stdin and process the request accordingly.

#Application Language 
-- This application is written in Java with Maven . 

#How to build the Application
#Using eclipse 
--This is a maven structured application , you can easily import it in eclipse by importing this application as a maven application.
  Once the application has been imported , you can do a RUN AS - > Maven install and then RUN AS -> Java Application or RUN AS - >              DEBUG install and then DEBUG AS -> Java Application
--When we do a install it will fetch all the dependencies and run all the Test Cases  and then you can chose run as java application and pass VM arguments through eclipse

#Using CMD 
Please note since we are building a maven project javac wont work . 

Please use this approach to run the code 
--make sure you navigate to project path . 
you can then do mvn install to build the jar . 

--Then navigate to the jar
for example C:\Users\Dhaval\eclipse-workspace\CreditCardPrototype\target>

Once in the target folder you can run it like this 
java -jar CreditCardPrototype-0.0.1-SNAPSHOT.jar Add Tom 4111111111111111 $1000 Add Lisa 5454545454545454 $3000 Add Quincy 1234567890123456 $2000 Charge Tom $500 Charge Tom $800 Charge Lisa $7 Credit Lisa $100 Credit Quincy $200

or
ps: please make sure you have copied the input.txt in the target folder . 
java -jar CreditCardPrototype-0.0.1-SNAPSHOT.jar input.txt


#Design Approach
--This application can be built in any language , but I choose to use JAVA for the application as I felt it would be very easy and simple to design a robust and scalable framework in JAVA , and also Java is one my strongest language. 

--I have built this application as a REST design (Micro Service Architecture) where we have a orchestrator (main controller) who will determine based on the request which service should handle the request, Which makes the architecture very robust , easily scalable and each service will be independent of other .

Note: Since this was a test and no database have been used , I have tried to use different dataStructures to demonstrate my skills as well as to accomplish the task . 


#Input and Result 

Given the following input:

```
Add Tom 4111111111111111 $1000
Add Lisa 5454545454545454 $3000
Add Quincy 1234567890123456 $2000
Charge Tom $500
Charge Tom $800
Charge Lisa $7
Credit Lisa $100
Credit Quincy $200
```

This program will produce the following output:

```
Lisa: $-93
Quincy: error
Tom: $500
```




