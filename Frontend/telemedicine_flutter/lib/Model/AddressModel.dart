import 'dart:convert';

Address addressJson(String str) {
  
  print("The address JSON: " + str);
  
  return Address.fromJson(json.decode(str));
}
  

String addressToJson(Address? data) {
  
  if(data != null) {
    return json.encode(data.toJson());

  } else {
    return "null";
  }
} 

class Address {

  int? postCode;
  String? city;
  String? country;
  String? state;
  String? streetName;
  int? streetNo;

  Address(this.streetNo, this.streetName, this.city, this.state, this.postCode, this.country);

  Address.fromJson(Map<String, dynamic> json) :
    streetNo = json["streetNo"],
    streetName = json["streetName"],
    city = json["city"],
    state = json["state"],
    postCode = json["postCode"],
    country = json["country"]
  ;

  Map<String, dynamic> toJson() => {
    "streetNo": streetNo,
    "streetName": streetName,
    "city": city,
    "state": state,
    "postCode": postCode,
    "country": country,
  };

  int? get getPostcode => postCode;
  String? get getCity => city;
  String? get getCountry => country;
  String? get getState => state;
  String? get getStreetName => streetName;
  int? get getStreetNo => streetNo;
}