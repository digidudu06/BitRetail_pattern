function People(name, age, gender, job){	//defua
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.job = job;
}
// 오버로딩(중복정의)은 이미 내장되어 있다.
People.prototype.setName = name=>{this.name = name;};
People.prototype.setAge = age=>{this.age = age;};
People.prototype.setGender = gender=>{this.gender = gender;};
People.prototype.setJob = job=>{this.job = job;};
People.prototype.getName = ()=>{return this.name;};
People.prototype.getAge = ()=>{return this.age;};
People.prototype.getGender = ()=>{return this.gender;};
People.prototype.getJob = ()=>{return this.job;};

function Customer(grade, custNo){
	People.apply(this, arguments);
	this.grade = grade;
	this.custNo = custNo;
}

Customer.prototype = new People();

Customer.prototype.setName = name=>{
	//this.name = '[닉네임] '+name; 이건 자바 문법
	Object.getPrototypeOf(Customer.prototype).setName('[닉네임] '+name); //오버라이딩 getPrototypeOf
};
Customer.prototype.setGrade = grade=>{this.grade = grade;};
Customer.prototype.setCustNo = custNo=>{this.custNo = custNo;};
Customer.prototype.getGrade = ()=>{return this.grade;};
Customer.prototype.getCustNo = ()=>{return this.custNo;};

var test2 = {//오버라이딩(재정의)
		main: ()=>{
			let cust = new Customer();
			cust.setName('홍길동');
			cust.setAge('20');
			cust.setGender('남');
			cust.setJob('도둑');
			cust.setGrade('gold');
			cust.setCustNo('1000');
			alert("고객정보 : "+cust.getName() 
					+ "," + cust.getAge() 
					+ "," + cust.getGender()
					+ "," + cust.getJob()
					+ "," + cust.getGrade()
					+ "," + cust.getCustNo());
		}};	//JSON(=객체) 리터럴




