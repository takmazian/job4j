import java.util.Comparator;
import java.util.Objects;

public class Department implements Comparable<Department> {
    public String getCodeSubDepartment() {
        return codeSubDepartment;
    }

    private String codeSubDepartment;

    public Department(String codeSubDepartment){
        this.codeSubDepartment =codeSubDepartment;
    }

    @Override
    public int compareTo(Department o) {
        if(o.hashCode() == this.hashCode()){
            return 0;
        }
        else{
            int result = 0;
            String left = this.getCodeSubDepartment();
            String right = o.getCodeSubDepartment();
            int minLength = left.length() > right.length() ? right.length() : left.length();
            int i;
            for (i = 0; i < minLength; i++) {
                int leftSymb = left.charAt(i);
                int rightSymb = right.charAt(i);
                if (leftSymb != rightSymb) {
                    result = Integer.compare(leftSymb, rightSymb);
                    break;
                }
            }
            if (result == 0) {
                if(left.length() < right.length()){
                    result =  -1;
                }
                else if(left.length() > right.length() ){
                    result = 1;
                }
            }
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(getCodeSubDepartment(), that.getCodeSubDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodeSubDepartment());
    }
}
