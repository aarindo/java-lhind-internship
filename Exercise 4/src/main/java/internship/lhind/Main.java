package internship.lhind;

import model.entity.Employee;
import model.entity.Office;
import repository.impl.EmployeeRepository;
import repository.impl.OfficeRepository;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository employee = new EmployeeRepository();
        OfficeRepository office = new OfficeRepository();

        System.out.println(employee.findById(1002));
        employee.exists(1002);

        Employee employee1 = new Employee(12345, "Mbiemri", "Emri", "x54321", "Emri.Mbiemri@gmail.com", "1", "1002", "Accountant");
        employee.save(employee1);

        Employee employee2 = new Employee(12345, "Mbiemer", "Emer", "x12345", "Mbiemri.Emri@gmail.com", "1", "1002", "Accountant");
        employee.update(employee2);

        System.out.println(office.findById(String.valueOf(2)));
        office.exists(String.valueOf(1));

        Office office1 = new Office("219", "Tiranadse", "+355684751222", "211 St. Treni", "Floor 0", "Albania", "Albania", "1001", "EUROPE");
        office.save(office1);

        Office office2 = new Office("219", "Tirana", "+356694351232", "105 Komune Parisi", "Floor 1", "ALB", "ALB", "1002", "EU");
        office.update(office2);
    }
}