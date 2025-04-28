import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            Person person = new Person(Integer.parseInt(data[0]), data[1], i);
            list.add(person);
        }

        Collections.sort(list, (a,b) -> {
            if(a.getAge() < b.getAge()) {
                return -1;
            } else if(a.getAge() > b.getAge()) {
                return 1;
            } else {
                if(a.getIndex() < b.getIndex()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            Person person = list.get(i);
            bw.write(person.getAge() + " " + person.getName() + "\n");
        }
        bw.flush();
    }

    static class Person {
        int age;
        String name;
        int index;

        Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public int getIndex() {
            return index;
        }
    }
}