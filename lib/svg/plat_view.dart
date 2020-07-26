

import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class PlatformPage extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return PlatformPageState();
  }

}

class PlatformPageState extends State<PlatformPage> {

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
    final size = MediaQuery.of(context).size;
    return Container(
      width: size.width,height: size.height,
      child: ListView(
        children: List.generate(30, (index){
          return Container(
            width: 200,height: 200,
            child: getAndroidTextView(),
          );
        }),
      ),
    );
  }
}