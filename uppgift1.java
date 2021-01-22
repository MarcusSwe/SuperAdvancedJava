package packageUppgift1;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;



public class uppgift1 {

    public static void main(String[] args) {

        List<String> myList = Arrays.asList(arrayFilText.getTextArray().clone());

        List<String> alpha = myList
                .stream()
                .filter(x-> x.length()>8)
                .collect(Collectors.toList());
        System.out.println("Antal ord större än 8: " +alpha.size());


        List<String> alpha2 = myList
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Antal unika ord: " + alpha2.size());


        List<String> alpha3 = myList
                .stream()
                .filter(x-> x.length()<4)
                .collect(Collectors.toList());
        System.out.println("Antal ord färre än 4: " +alpha3.size());


        List<String> alpha4 = myList
                .stream()
                .distinct()
                .filter(x-> x.length()>8)
                .collect(Collectors.toList());
        System.out.println("Antal unika ord med fler bokstäver än 8: " + alpha4.size());



        List<Double> alpha5 = myList
                .stream()
                .map(x -> (double)x.length())
                .collect(Collectors.toList());
        Double sum = alpha5
                .stream()
                .collect(Collectors.summingDouble(Double::doubleValue));
        System.out.println("Den genomsnittliga ordlängden: " + sum/alpha5.size());
        System.out.println("Totala Antalet tecken: " + sum);



        Predicate<String> p1 = s -> s.length()<12;
        Predicate<String> p2 = s -> s.length()>2;
        List<String> alpha6 = myList
                .stream()
                .filter(p1)
                .collect(Collectors.toList());
        if(myList.size() == alpha6.size()) {
            System.out.println("Ja alla ord är kortare än 12");
        }else System.out.println("Nej alla ord är inte kortare än 12");

        List<String> alpha7 = myList
                .stream()
                .filter(p2)
                .collect(Collectors.toList());
        if(myList.size() == alpha7.size()) {
            System.out.println("Ja alla ord är längre än 2");
        }else System.out.println("Nej alla ord är inte längre än 2");




        DoubleStream myStream = Arrays.stream(arrayFilNummer.getNumberArray().clone());
        double[] omega = myStream
                .filter(x -> x>1000)
                .toArray();
        System.out.println("Antal större tal än 1000: " + omega.length);



        DoubleStream myStream2 = Arrays.stream(arrayFilNummer.getNumberArray().clone());
        double[] omega2 = myStream2
                .filter(x -> x<1000)
                .map(x -> (int)x)
                .filter(x-> x%3 == 0)
                .distinct()
                .toArray();


       DoubleStream omega3 = Arrays.stream(omega2);
       int value = omega3
              .mapToInt(x -> (int)Math.round(x))
              .filter(x -> x<500)
              .sum();
       System.out.println("Summan av alla tal under 500 är: " + value);


       DoubleStream omega4= Arrays.stream(arrayFilNummer.getNumberArray().clone());
       OptionalDouble value2 = omega4
                .filter(x -> x<3000)
                .filter(x -> x>2000)
                .average();
       System.out.println("Medelvärdet för alla tal mellan 2000 och 3000 är: " + value2);


       DoubleStream omega5= Arrays.stream(arrayFilNummer.getNumberArray().clone());
       OptionalDouble value3 = omega5
                .max();
       System.out.println("Största värdet är: " + value3);


       DoubleStream omega6= Arrays.stream(arrayFilNummer.getNumberArray().clone());
       OptionalDouble value4 = omega6
                .min();
       System.out.println("Minsta värdet är: " + value4);


       MyObject[] beta = new MyObject[50];
       for (int i = 0; i < 50; i++){
           boolean easy = (Math.random() < 0.5);
           String[] betaname = arrayFilText.getTextArray().clone();
           int easy2 = (int)(Math.random() * 1150);
           beta[i] = new MyObject(easy,(int)(Math.random()*50)+1, betaname[easy2]);
        };


      List<MyObject> myObjectList = Arrays.asList(beta);

      List<MyObject> betaTest = myObjectList
              .stream()
              .filter(x -> x.getInt()>20)
              .collect(Collectors.toList());


      List<MyObject> betaTest2 = myObjectList
                .stream()
                //.map(s -> s.getBoolean() == true)
                .filter(s -> s.getBoolean() == true)
                .map(x -> {x.setString("this is true"); return x;})
                .collect(Collectors.toList());

       for (int p = 0; p < betaTest.size(); p++){
            System.out.print(betaTest.get(p).getBoolean()+" ");
            System.out.print(betaTest.get(p).getInt() +" ");
            System.out.print(betaTest.get(p).getString()+ " ");
            System.out.println("");
        }

      for (int p = 0; p < betaTest2.size(); p++){
            System.out.print(betaTest2.get(p).getBoolean()+" ");
            System.out.print(betaTest2.get(p).getInt() +" ");
            System.out.print(betaTest2.get(p).getString()+ " ");
            System.out.println("");
      }

      int[] betaAverage = new int[50];
      for (int p = 0; p < beta.length; p++){
         betaAverage[p] = beta[p].getInt();
      }



      System.out.println("Medelvärdet på siffrorna är: " + del3average(betaAverage));



    }

    public static double del3average(int[] array) {
        return Arrays.stream(array).average().orElse(Double.NaN);
    }


}
