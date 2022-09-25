import 'dart:convert';

PatientModel patientModelJson(String str) =>
  PatientModel.fromJson(json.decode(str));

String patientModelToJson(PatientModel data) => json.encode(data.toJson());

class PatientModel {

  int id;
  String email;
  String password;
  String userType;
  String firstName;
  String middleName;
  String lastName;
  int phone;
  DateTime birth;
  String gender;
  String address;
  double height;
  double weight;
  String healthInformation;
  String healthStatus;

  PatientModel(this.id, this.email, this.password, this.userType, 
  this.firstName, this.middleName, this.lastName, this.phone, this.birth, 
  this.gender, this.address, this.height, this.weight, this.healthInformation, 
  this.healthStatus);

  PatientModel.fromJson(Map<String, dynamic> json) :
    id = json["id"],
    email = json["email"],
    password = json["password"],
    userType = json["userType"],
    firstName = json["firstName"],
    middleName = json["middleName"],
    lastName = json["lastName"],
    phone = json["phone"],
    birth = json["birth"],
    gender = json["gender"],
    address = json["address"],
    height = json["height"],
    weight = json["weight"],
    healthInformation = json["healthInformation"],
    healthStatus = json["healthStatus"]
  ;

  Map<String, dynamic> toJson() => {
    "id": id,
    "email": email,
    "password": password,
    "userType": userType,
    "firstName": firstName,
    "middleName": middleName,
    "lastName": lastName,
    "phone": phone,
    "birth": birth,
    "gender": gender,
    "address": address,
    "height": height,
    "weight": weight,
    "healthInformation": healthInformation,
    "healthStatus": healthStatus
  };

  String get getId => id.toString();
  String get getEmail => email;
  String get getPassword => password;
  String get getUserType => userType;
  String get getFirstName => firstName;
  String get getMiddleName => middleName;
  String get getLastName => lastName;
  String get getPhone => phone.toString();
  String get getBirth => birth.toString();
  String get getGender => gender;
  String get getAddress => address;
  String get getHeight => height.toString();
  String get getWeight => weight.toString();
  String get getHealthInformation => healthInformation;
  String get getHealthStatus => healthStatus;

}