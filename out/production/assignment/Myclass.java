import java.util.*;
import java.util.stream.Collectors;

public class Myclass {
    public static void main(String[] args) {
//
//        System.out.println(Runtime.getRuntime().availableProcessors());

        q12();

    }

    public static void q1(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul",1200)
                ,new Employee("Ram",12003)
                ,new Employee("Karan",500000));

        List<Employee> employees2 = employees.stream()
                .filter(x -> x.salary>50000)
                .toList();
    }

    public static void q2(){
        List<String> words=Arrays.asList("Ram","Karan","Rahul","Ram");
        Map<String,Long> map=  words.stream()
                .collect(Collectors.groupingBy
                        (x -> x,
                                Collectors.counting()));
        System.out.println(map);
    }



    public static void q3(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul","ml")
                ,new Employee("Ram","al")
                ,new Employee("Kunal","ml")
                ,new Employee("Sanjay","ml")
                ,new Employee("Rajesh","al")
                ,new Employee("Karan","al"));

        Map<String,List<Employee>> ans=employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,Collectors.toList()
                ));
        System.out.println(ans);

        ans.forEach((dep,employee)->
                {
                    System.out.println("Department: "+dep);
                    employee.forEach(System.out::println);
                }

        );


    }
    public  static void q4(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul",1200)
                ,new Employee("Ram",12003)
                ,new Employee("Karan",500000));

//        Employee e=employees.stream()
//                .reduce(new Employee("",0),(x,y)-> x.salary>y.salary?x:y
//                );
        Employee e1=employees.stream()
                .max(Comparator.comparingDouble(x->x.salary)).orElse(null);


        System.out.println("Maximum salary is "+e1.salary);

    }
    public static void q5(){
        List<String> languages = Arrays.asList("Java", "Python", "C++");

        String ans=languages.stream()
                .collect(Collectors.joining(","));


// Just join elements with no delimiter
//        joining()
//
//// Join elements separated by a delimiter
//        joining(CharSequence delimiter)
//
//// Join elements with delimiter, prefix and suffix
//        joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)


        System.out.println(ans);

    }
    public static void q6(){
        List<Integer> numbers = Arrays.asList(1,2,3,2,3,4,5,6,7,8,9,100,4,5,6,7,8,9);

        List<Integer> ans=numbers.stream().distinct().collect(Collectors.toList());

        System.out.println(ans);
    }

    public static void q7(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul",2)
                ,new Employee("Ram",3)
                ,new Employee("Kunal",4)
                ,new Employee("Sanjay",6)
                ,new Employee("Rajesh",8)
                ,new Employee("Karan",10));

        Map<Boolean,List<Employee>> res=employees.stream()
                .collect(Collectors.partitioningBy(x->x.experience>=5));

        System.out.println(res);
    }

    public static void q8(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul","ml",1000)
                ,new Employee("Ram","al",1393234)
                ,new Employee("Kunal","ml",103023)
                ,new Employee("Sanjay","ml",2302013)
                ,new Employee("Rajesh","al",12030)
                ,new Employee("Karan","al",2103));

        Map<String,Double> ans=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(x->x.salary)));

        System.out.println(ans);

    }

    public static void q9(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul","ml",1000)
                ,new Employee("Ram","al",1393234)
                ,new Employee("Kunal","ml",103023)
                ,new Employee("Sanjay","ml",2302013)
                ,new Employee("Rajesh","al",12030)
                ,new Employee("Karan","al",2103));

        List<String> ans=employees.stream().sorted(Comparator.comparing((Employee x)->x.salary).reversed()).limit(3).map(Employee::getName).collect(Collectors.toList());

        System.out.println(ans);

    }
    public static void q10(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul","ml",1000)
                ,new Employee("Ram","al",1393234)
                ,new Employee("Kunal","ml",103023)
                ,new Employee("Sanjay","ml",2302013)
                ,new Employee("Rajesh","al",12030)
                ,new Employee("Karan","al",2103));

        List<Employee> ans=employees.stream().sorted(Comparator.comparing((Employee x)->x.salary).reversed()).collect(Collectors.toList());

        System.out.println(ans);

    }
    public static void q11(){
        List<Employee> employees = Arrays.asList(new Employee("Rahul","ml",1000)
                ,new Employee("Ram","al",1393234)
                ,new Employee("Kunal","ml",103023)
                ,new Employee("Sanjay","ml",2302013)
                ,new Employee("Rajesh","al",12030)
                ,new Employee("Karan","al",2103));

        List<String> departments=Arrays.asList("ai","rac","ml","al");

        Set<String> nodep=employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());

        List<String> ans=  departments.stream().filter( x -> !nodep.contains(x)).collect(Collectors.toList());

        System.out.println(ans);
    }

    public static void q12(){
        List<String> names = Arrays.asList("Alice", "Andrew", "Bob", "Charlie");
        Map<Character,List<String>>  ans=names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(ans);

    }

}