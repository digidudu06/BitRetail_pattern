package enums;

public enum ImageSQL {
	IMG_STORE;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case IMG_STORE:
			query.append("INSERT INTO IMAGES(IMG_SEQ, IMG_NAME, IMG_EXTENTION, OWNER)\n" + 
					"VALUES(IMG_SEQ.NEXTVAL,?,?,?)");
			break;

		default:
			break;
		}
		
		return query.toString();
	}
	
}
