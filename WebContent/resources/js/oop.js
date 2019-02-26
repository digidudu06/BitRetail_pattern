var inherit = (()=>{
	return{
		main: ()=>{
			let emp1 = new Employee();
			emp1.setSalary('500');
			emp1.setPosition('팀장');
			alert("정보 : "+emp1.getSalary()+','+emp1.getPosition());
			
			let cust1 = new Customer();
			cust1.setCustNo('1000');
			cust1.setGrade('gold');
			alert("정보 : "+cust1.getCustNo()+','+cust1.getGrade());
		}
	};
})();
function Employee (){
	let _salary, _position;
	return{
		setSalary : (salary)=>{this._salary = salary;},
		setPosition : (position)=>{this._position = position;},
		getSalary : ()=>{return this._salary;},
		getPosition : ()=>{return this._position},
		toString : ()=>{return this._salary + ',' + this._position;}
	};
};
function Customer(){
	let _custNo, _grade;
	return{
		setCustNo : (custNo)=>{this._custNo = custNo;},
		setGrade : (grade)=>{this._grade = grade;},
		getCustNo : ()=>{return this._custNo;},
		getGrade : ()=>{return this._grade},
		toString : ()=>{return this._grade + ',' + this._custNo;}
	};
};


//------------------------------------------------------------------
var encap = (()=>{
	var main =()=>{
		person.setName('도널드 트럼프');
        person.setAge('72');
        person.setGender('남');
        person.setJob('미국 대통령');
		alert('스펙: '+person.toString());
	};
	return {main:main};
})();
var person = (()=>{
	let _name, _age, _gender, _job; // let 지역(인스턴스변수), var 전역
	return{
		setName:(name)=>{this._name = name;},
		setAge:(age)=>{this._age = age;},
		setGender:(gender)=>{this._gender = gender;},
		setJob:(job)=>{this._job = job;},
		getName:()=>{return this._name;},
		getAge:()=>{return this._age;},
		getGender:()=>{return this._gender;},
		getJob:()=>{return this._job;},
		toString:()=>{return this._name+',' +this._age+',' +this._gender+',' +this._job;}
	};
})();



