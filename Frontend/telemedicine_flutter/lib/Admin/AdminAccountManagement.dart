import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

class AccountManagement extends StatefulWidget {
  const AccountManagement({Key? key}) : super(key: key);

  @override
  State<AccountManagement> createState() => _AccountManagementState();
}

class _AccountManagementState extends State<AccountManagement> {
  TextEditingController textEditingController = TextEditingController();

//   List<User> users = allUsers;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.grey,
        title: const Text(
          'Account Management',
          style: TextStyle(color: Colors.black),
        ),
        centerTitle: true,
        actions: [
          IconButton(
              icon: const Icon(Icons.notifications),
              color: Colors.black,
              onPressed: () {}),
          IconButton(
              icon: const Icon(Icons.question_mark_outlined),
              color: Colors.black,
              onPressed: () {}),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(15),
        child: ListView(children: const <Widget>[
          Padding(
            padding: EdgeInsets.all(15),
            child: TextField(
              decoration: InputDecoration(
                prefixIcon: Icon(Icons.search),
                border: OutlineInputBorder(),
                labelText: 'Search',
                hintText: 'Serach for an account',
              ),
            ),
          ),
        ]),
      ),
    );
  }
}
