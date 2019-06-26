import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortDepartment {
    static List<Department> sortDepartmentAsc(List<Department> departmentList) {
        Comparator<Department> comparator = (o1, o2) -> {
            int result = 0;
            String left = o1.getCodeSubDepartment();
            String right = o2.getCodeSubDepartment();
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
            if (result == 0 && left.length() != right.length()) {
                result = Integer.compare(left.length(), right.length()) == 1 ? 1 : -1;
            }
            return result;
        };
        ArrayList<Department> result = new ArrayList<>(departmentList);
        result.sort(comparator);
        return result;
    }

    static List<Department> sortDepartmentDesc(List<Department> departmentList) {
        Comparator<Department> comparator = (o1, o2) -> {
            int result = 0;
            String left = o1.getCodeSubDepartment();
            String right = o2.getCodeSubDepartment();
            int minLength = left.length() > right.length() ? right.length() : left.length();
            int i;
            for (i = 0; i < minLength; i++) {
                int leftSymb = left.charAt(i);
                int rightSymb = right.charAt(i);
                if (leftSymb != rightSymb) {
                    result = Integer.compare(rightSymb, leftSymb);
                    break;
                }
            }
            if (result == 0 && left.length() != right.length()) {
                result = Integer.compare(left.length(), right.length()) == 1 ? 1 : -1;
            }
            return result;
        };
        ArrayList<Department> result = new ArrayList<>(departmentList);
        result.sort(comparator);
        return result;
    }
}
