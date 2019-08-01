import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDepartment {
    private List<Department> departments;

    public SortDepartment(List<Department> departments) {
        this.departments = new ArrayList<>(departments);
        this.addMissingDeps();
    }

    private void addMissingDeps() {
        List<Department> departments = this.departments;
        List<Department> addList = new ArrayList<>();
        for (Department department : departments) {
            int nach = 0;
            int match = department.getCodeSubDepartment().indexOf('\\', nach);
            while (match != -1) {
                boolean isFound = false;
                String newDep = department.getCodeSubDepartment().substring(0, match);
                Department newDepObj = new Department(newDep);
                if (!departments.contains(newDepObj)) {
                    if(!addList.contains(newDepObj)){
                        addList.add(newDepObj);
                    }
                }
                nach = match + 1;
                match = department.getCodeSubDepartment().indexOf('\\', nach);
            }
        }
        departments.addAll(addList);
    }

    public List<Department> getDepartments(){
        return departments;
    }

    public List<Department> sortDepartmentAsc() {
        Collections.sort(departments);
        return departments;
    }

    public List<Department> sortDepartmentDesc() {
        departments.sort(new DescComparator());
        return departments;
    }

    static class DescComparator implements Comparator<Department> {

        @Override
        public int compare(Department o1, Department o2) {
            if (o1.hashCode() == o2.hashCode()) {
                return 0;
            } else {
                int result = 0;
                String left = o1.getCodeSubDepartment();
                String right = o2.getCodeSubDepartment();
                int minLength = Math.min(left.length(), right.length());
                int i;
                for (i = 0; i < minLength; i++) {
                    int leftSymb = left.charAt(i);
                    int rightSymb = right.charAt(i);
                    if (leftSymb != rightSymb) {
                        result = -Integer.compare(leftSymb, rightSymb);
                        break;
                    }
                }
                if (result == 0) {
                    if (left.length() < right.length()) {
                        result = -1;
                    } else if (left.length() > right.length()) {
                        result = 1;
                    }
                }
                return result;
            }
        }
    }
}
