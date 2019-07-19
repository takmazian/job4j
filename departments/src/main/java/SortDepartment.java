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
        result.sort(Collections.reverseOrder());
        return result;
    }
}
