/*
* Author : LiJiqqi
* Date : 2020/7/23
*/



import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class ComplexPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return ComplexPageState();
  }

}

class ComplexPageState extends State<ComplexPage> {

  Widget getAndroidTextView(){
    if(Platform.isAndroid){
      return AndroidView(viewType: "platform_text_view",
        creationParams: <String,String>{"text":"this is a value from flutter to android"},
        creationParamsCodec: const StandardMessageCodec(),);
    }else{
      return Text("get android view wrong");
    }
  }
  @override
  Widget build(BuildContext context) {
    return Material(
      color: Colors.white,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Text('complex page'),
          Container(
            width: 200,height: 200,
            color: Colors.greenAccent,
            alignment: Alignment.center,
            child: getAndroidTextView(),
          ),
        ],
      ),
    );
  }
}
