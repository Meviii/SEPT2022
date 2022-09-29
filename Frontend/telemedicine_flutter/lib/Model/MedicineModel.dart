import 'dart:convert';

String medicineToJson(Medicine data) => json.encode(data.toJson());

class Medicine {

  int id;
  String name;
  String description;
  int dosage;

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

  int get getId => id;
  String get getName => name;
  String get getDescription => description;
  int get getDosage => dosage;
}