package enums;

public enum CustomerSQL {
	SIGNUP, SIGNIN, LIST, ROW_COUNT, CUS_PHONE, CUST_RETRIEVE, CUST_UPDATE;
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,PASSWORD,SSN,PHONE,POSTAL_CODE,ADDRESS,CITY) " + 
					"VALUES(?,?,?,?,?,?,?,?)");
			break;
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS " + 
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		case LIST:
			query.append("SELECT T2.*\n" + 
					"FROM (SELECT ROWNUM R2, T.*\n" + 
					"        FROM (SELECT ROWNUM RNUM, C.*\n" + 
					"                FROM CUSTOMERS C\r\n" + 
					"                ORDER BY RNUM DESC) T) T2\n" + 
					"WHERE R2 BETWEEN ? AND ?");
			break;
		case ROW_COUNT:
			query.append("SELECT COUNT(*) COUNT FROM CUSTOMERS");
			break;
		case CUS_PHONE:
			query.append("SELECT CUSTOMER_ID, CUSTOMER_NAME, PHONE \n" + 
					"FROM CUSTOMERS");
			break;
		case CUST_RETRIEVE:
			query.append("SELECT * FROM CUSTOMERS\n" + 
					"WHERE CUSTOMER_ID LIKE ?");
			break;
		case CUST_UPDATE:
			query.append("UPDATE CUSTOMERS \n" + 
					"SET PASSWORD = ?\n" + 
					",ADDRESS = ?\n" + 
					",CITY = ?\n" + 
					",POSTAL_CODE = ?\n" + 
					",PHONE = ?\n" + 
					"WHERE CUSTOMER_ID = ?");
			break;
		default:
			break;
		}
		return query.toString();
	}
}
