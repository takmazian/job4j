import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDepartment {
    static List<Department> sortDepartmentAsc(List<Department> departmentList) {
        ArrayList<Department> result = new ArrayList<>(departmentList);
        Collections.sort(result);
        return result;
    }

    static List<Department> sortDepartmentDesc(List<Department> departmentList) {
        ArrayList<Department> result = new ArrayList<>(departmentList);
        result.sort(new DescComparator());
        return result;
    }

    static class DescComparator implements Comparator<Department>{

        @Override
        public int compare(Department o1, Department o2) {
            if(o1.hashCode() == o2.hashCode()){
                return 0;
            }
            else{
                int result = 0;
                String left = o1.getCodeSubDepartment();
                String right = o2.getCodeSubDepartment();
                int minLength = Math.min(left.length(), right.length());
                int i;
                for (i = 0; i < minLength; i++) {
                    int leftSymb = left.charAt(i);
                    int rightSymb = right.charAt(i);
                    if (leftSymb != rightSymb) {
                        result = - Integer.compare(leftSymb, rightSymb);
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
    }
}
