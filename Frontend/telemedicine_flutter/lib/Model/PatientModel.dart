import 'dart:convert';
import 'package:intl/intl.dart';

import 'AddressModel.dart';

String patientToJson(Patient data) => json.encode(data.toJson());

class Patient {

  int id;
  String email;
  String password;
  String? userType;
  String firstName;
  String? middleName;
  String lastName;
  int? phone;
  DateTime birth;
  String? gender;
  Address? address;
  bool? verifiedStatus;
  bool? disabledStatus;
  double height;
  double weight;
  String healthInformation;
  String healthStatus;

  Patient(this.id, this.email, this.password, this.userType, 
  this.firstName, this.middleName, this.lastName, this.phone, this.birth, 
  this.gender, this.address, this.verifiedStatus, this.disabledStatus, this.height, 
  this.weight, this.healthInformation, this.healthStatus);

  Patient.fromJson(Map<String, dynamic> json) :
    id = json["id"],
    email = json["email"],
    password = json["password"],
    userType = json["userType"],
    firstName = json["firstName"],
    middleName = json["middleName"],
    lastName = json["lastName"],
    phone = json["phone"],
    birth = DateFormat('yy-MM-dd').parse(json["birth"]),
    gender = json["gender"],
    address = Address.fromJson(json["address"]),
    verifiedStatus = json["verifiedStatus"],
    disabledStatus = json["disabledStatus"],
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
    "address": addressToJson(address),
    "verifiedStatus": verifiedStatus,
    "disabledStatus": disabledStatus,
    "height": height,
    "weight": weight,
    "healthInformation": healthInformation,
    "healthStatus": healthStatus
  };

  int get getId => id;
  String get getEmail => email;
  String get getPassword => password;
  String get getFirstName => firstName;
  String get getLastName => lastName;
  DateTime get getBirth => birth;
  Address? get getAddress => address;
  double get getHeight => height;
  double get getWeight => weight;
  String get getHealthInformation => healthInformation;
  String get getHealthStatus => healthStatus;

  String? get getUserType {

    if(userType == null) {
      return "";
    }

    return userType;
  }
  
  String? get getMiddleName {

    if(middleName == null) {

      return "";
    }

    return middleName;
  }

  String? get getPhone {
    
    if(phone == null) {
      return "";
    }

    return phone.toString();
    
  }
  
  String? get getGender {
    
    if(gender == null) {
      return "";
    }

    return gender;
  }
  
  String get getVerifiedStatus {
    
    if(verifiedStatus == null) {
      return "Unavailable";

    } else if(verifiedStatus == true) {
      return "True";

    } else {
      return "False";
    }
  }

  String get getDisabledStatus {
    
    if(disabledStatus == null) {
      return "Unavailable";

    } else if(disabledStatus == true) {
      return "True";

    } else {
      return "False";
    }
  }
}