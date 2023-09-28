package equals;


/**
 * @Author: suruomo
 * @Date: 2021/8/21 13:03
 * @Description: 重写equals贺hashcode
 */
public class Student {
    private String name;

    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        int result=17;
        result=result*33+((name==null)?0:name.hashCode())+((age==null?0:age.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null){
            return false;
        }
        Student student=(Student) o;
        return this.name==student.name&& this.age.equals(student.age);
    }
}
