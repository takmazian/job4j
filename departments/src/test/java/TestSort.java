import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSort {

    @Test
    public void testSortAsc(){
        Department dep1 = new Department("K1\\SK1");
        Department dep2 = new Department("K1\\SK2");
        Department dep3 = new Department("K1\\SK1\\SSK1");
        Department dep4 = new Department("K1\\SK1\\SSK2");
        Department dep5 = new Department("K2");
        Department dep6 = new Department("K2\\SK1\\SSK1");
        Department dep7 = new Department("K2\\SK1\\SSK2");
        Department dep8 = new Department("K1");
        Department dep10 = new Department("K2\\SK1");
        List<Department> departmentList = List.of(dep1,dep2,dep3,dep4,dep5,dep6,dep7,dep8,dep10);
        assertThat(SortDepartment.sortDepartmentAsc(departmentList), is(List.of(dep8,dep1,dep3,dep4,dep2,dep5,dep10,dep6,dep7)));
    }

    @Test
    public void testSortDesc(){
        Department dep1 = new Department("K1\\SK1");
        Department dep2 = new Department("K1\\SK2");
        Department dep3 = new Department("K1\\SK1\\SSK1");
        Department dep4 = new Department("K1\\SK1\\SSK2");
        Department dep5 = new Department("K2");
        Department dep6 = new Department("K2\\SK1\\SSK1");
        Department dep7 = new Department("K2\\SK1\\SSK2");
        Department dep8 = new Department("K1");
        Department dep10 = new Department("K2\\SK1");
        List<Department> departmentList = List.of(dep1,dep2,dep3,dep4,dep5,dep6,dep7,dep8,dep10);
        assertThat(SortDepartment.sortDepartmentDesc(departmentList), is(List.of(dep5,dep10,dep7,dep6,dep8,dep2,dep1,dep4,dep3)));
    }
}
