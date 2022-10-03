import 'package:flutter/material.dart';

import '../Model/MedicineModel.dart';

class Accordion extends StatefulWidget {
  final String title;
  final List<Medicine> medicineList;

  const Accordion({Key? key, required this.title, required this.medicineList})
      : super(key: key);
  @override
  _AccordionState createState() => _AccordionState();
}

class _AccordionState extends State<Accordion> {
  bool _showContent = false;
  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.all(10),
      child: Column(children: [
        ListTile(
          title: Text(widget.title),
          trailing: IconButton(
            icon: Icon(
                _showContent ? Icons.arrow_drop_up : Icons.arrow_drop_down),
            onPressed: () {
              setState(() {
                _showContent = !_showContent;
              });
            },
          ),
        ),
        _showContent
            ? Container(
                padding: const EdgeInsets.symmetric(vertical: 15, horizontal: 15),
                child: ListView.builder(
                  shrinkWrap: true,
                  itemCount: widget.medicineList.length,
                  itemBuilder: (BuildContext context, int index) {

                    return Padding(
                      padding: const EdgeInsets.fromLTRB(0, 0, 0, 15),
                      child: Column( 
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                        Text('Medicine ID: ${widget.medicineList[index].getId}'),
                        Text('Name: ${widget.medicineList[index].getName}'),
                        Text('Description: ${widget.medicineList[index].getDescription}'),
                        Text('Dosage: ${widget.medicineList[index].getDosage}'),

                      ]),
                    );
                  }
                )
              )
            : Container()
      ]),
    );
  }
}