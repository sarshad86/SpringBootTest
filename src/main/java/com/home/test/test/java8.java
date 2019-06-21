package com.home.test.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sara on 2019/06/20.
 */
public class java8 {

    public static void main(String[] args) {

        List result = new ArrayList();
        Object[] tst = new Object[4];
        tst[0]= "Alert";
        tst[1]= "Recipient";
        tst[2]= "Rule";
        tst[3]= "AlertSendHistory";
        result.add(tst);


       /* Stream<ResultItem> s = result.stream().map(tuple -> {

            ResultItem resultItem = new ResultItem();
            Object[] parts = (Object[]) tuple;
            resultItem.add(Alert.NAME + "_" + Alert.class.getSimpleName(), parts[0]);
            resultItem.add(Recipient.NAME + "_" + Recipient.class.getSimpleName(), parts[1]);
            resultItem.add(Rule.NAME + "_" + Rule.class.getSimpleName(), parts[2]);
            resultItem.add(AlertSendHistory.DATETIME, parts[3]);
            return resultItem;

        });

        ResultList r = s.collect(Collectors.toCollection(ResultList::new));*/
        /*final ResultList r = (ResultList) result.stream().map(tuple -> {

            ResultItem resultItem = new ResultItem();
            Object[] parts = (Object[]) tuple;
            resultItem.add(Alert.NAME + "_" + Alert.class.getSimpleName(), parts[0]);
            resultItem.add(Recipient.NAME + "_" + Recipient.class.getSimpleName(), parts[1]);
            resultItem.add(Rule.NAME + "_" + Rule.class.getSimpleName(), parts[2]);
            resultItem.add(AlertSendHistory.DATETIME, parts[3]);
            return resultItem;

        }).collect(Collectors.toCollection(ResultList::new));
        System.out.println(r.size());*/

        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date="+firstDay_2014);

        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST="+todayKolkata);

        LocalTime time = LocalTime.now();
        System.out.println("Current Time="+time);

        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST="+timeKolkata);

        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));

        /*resultItems.forEach( item -> {
            System.out.println(item.toString());
        });*/
        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result2 = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result2);

        // Calling Predicate method
        boolean result3 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result3);

        Predicate<String> nonNullPredicate = Objects::nonNull;

        String nullString = null;

        boolean outcome = nonNullPredicate.and(hasLengthOf10).test(nullString);
        System.out.println(outcome);

        String lengthGTThan10 = "Welcome to the machine";
        boolean outcome2 = nonNullPredicate.and(hasLengthOf10).
                test(lengthGTThan10);
        System.out.println(outcome2);

        boolean outcomeb = hasLengthOf10.negate().test(lengthGTThan10);
        System.out.println(outcomeb);

        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.isPresent());

        long t1, t2;
        List<Employee> eList = new ArrayList<Employee>();
        for(int i=0; i<100; i++) {
            eList.add(new Employee("A", 20000));
            eList.add(new Employee("B", 3000));
            eList.add(new Employee("C", 15002));
            eList.add(new Employee("D", 7856));
            eList.add(new Employee("E", 200));
            eList.add(new Employee("F", 50000));
        }

        /***** Here We Are Creating A 'Sequential Stream' & Displaying The Result *****/
        t1 = System.currentTimeMillis();
        System.out.println("Sequential Stream Count?= " + eList.stream().filter(e -> e.getSalary() > 15000).count());

        t2 = System.currentTimeMillis();
        System.out.println("Sequential Stream Time Taken?= " + (t2-t1) + "\n");

        /***** Here We Are Creating A 'Parallel Stream' & Displaying The Result *****/
        t1 = System.currentTimeMillis();
        System.out.println("Parallel Stream Count?= " + eList.parallelStream().filter(e -> e.getSalary() > 15000).count());

        t2 = System.currentTimeMillis();
        System.out.println("Parallel Stream Time Taken?= " + (t2-t1));

        // new operator itself is a supplier, of the reference to the newly created object
        Supplier<List<String>> listSupplier = ArrayList::new;
        System.out.println(listSupplier.get());
        Consumer<String> printConsumer = a1 -> System.out.println(a1);
        printConsumer.accept("hello");
        Function<String, String> function = rr -> {
            return rr;
        };
        System.out.println(function.apply("hi"));
        BiConsumer<Integer, Integer> sumConsumer = (a1, a2) -> System.out.println(a1 + a2);

        List evens = Arrays.asList(2, 4, 6);
        List odds = Arrays.asList(3, 5, 7);
        List primes = Arrays.asList(2, 3, 5, 7, 11);
        List numbers = (List) Stream.of(evens, odds, primes).flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println("flattend list: " + numbers);


        String s1 = new String("GFG").intern(); // Line-1

        // S2 refers to Object in SCP Area
        String s2 = s1; // Line-2

        // Comparing memory locations
        // s1 is in Heap
        // s2 is in SCP
        System.out.println(s1 == s2);

        // Comparing only values
        System.out.println(s1.equals(s2));

        // S3 refers to Object in the SCP Area
        String s3 = "GFG"; // Line-3

        System.out.println(s2 == s3);
    }

    public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
        @Override
        public boolean test(String t)
        {
            return t.length() > 10;
        }
    };
}
