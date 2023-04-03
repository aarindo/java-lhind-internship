package util;

public final class Queries {

    private Queries() {
    }

    public static final String FIND_ALL_EMPLOYEES = "SELECT * FROM employees;";

    public static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE employeeNumber = ?;";

    public static final String FIND_IF_EMPLOYEE_EXISTS = "SELECT * FROM employees WHERE employeeNumber = ?;";

    public static final String ADD_EMPLOYEE = "INSERT INTO employees(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE lastName = VALUES(lastname), firstName = VALUES(firstName), extension = VALUES(extension), email = VALUES(email), officeCode= VALUES(officeCode), reportsTo= VALUES(reportsTo), jobTitle= VALUES(jobTitle);";

    public static final String UPDATE_EMPLOYEE = "UPDATE employees SET lastName = ?, firstName = ?, extension= ?, email= ?, officeCode = ?, reportsTo = ?, jobTitle = ? WHERE employeeNumber = ?;";

    public static final String FIND_ALL_OFFICES = "SELECT * FROM offices;";

    public static final String FIND_OFFICE_BY_ID = "SELECT * FROM offices WHERE officeCode = ?;";

    public static final String FIND_IF_OFFICE_EXISTS = "SELECT * FROM offices WHERE officeCode = ?;";

    public static final String ADD_OFFICE = "INSERT INTO offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory)  VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE city = VALUES(city), phone = VALUES(phone), addressLine1 = VALUES(addressLine1), addressLine2 = VALUES(addressLine2), state= VALUES(state), country= VALUES(country), postalCode= VALUES(postalCode), territory= VALUES(territory);";

    public static final String UPDATE_OFFICE = "UPDATE offices SET city = ?, phone= ?, addressLine1= ?, addressLine2= ?, state= ?, country= ?, postalCode= ? territory= ?  WHERE officeCode = ?;";
}
