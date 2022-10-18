import 'dart:convert';

String medicineToJson(Medicine data) => json.encode(data.toJson());

class Medicine {

  String id;
  String name;
  String description;
  String dosage;

  Medicine(this.id, this.name, this.description, this.dosage);

  Medicine.fromJson(Map<String, dynamic> json) :
    id = json["id"],
    name = json["name"],
    description = json["description"],
    dosage = json["dosage"]
  ;

  Map<String, dynamic> toJson() => {
    "id": id,
    "name": name,
    "description": description,
    "dosage": dosage
  };

  String get getId => id;
  String get getName => name;
  String get getDescription => description;
  String get getDosage => dosage;
}