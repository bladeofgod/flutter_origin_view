/*
* Author : LiJiqqi
* Date : 2020/7/23
*/



import 'dart:io';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_webview_plugin/flutter_webview_plugin.dart';
import 'package:webview_flutter/webview_flutter.dart';
//import 'package:flutter_webview_plugin/flutter_webview_plugin.dart';


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
    final Size size = MediaQuery.of(context).size;
    return Material(
      color: Colors.deepPurple,
      child: Container(
        padding: EdgeInsets.all(50),
        width: size.width,height: size.height,
        child:justWebP(size),

      ),
    );
  }

  Widget normal(Size size){
    return SingleChildScrollView(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Container(
            width: size.width,height: size.height/2,
            color: Colors.lightBlue,
          ),
          Text('complex page'),
//            Container(
//              padding: EdgeInsets.all(10),
//              width: size.width,height: size.height,
//              color: Colors.red,
//              child: WebView(
//                initialUrl: "https://www.tripalink.com",
//                javascriptMode: JavascriptMode.unrestricted,
//              ),
//            ),
//          WebView(
//            initialUrl: "https://www.tripalink.com",
//            javascriptMode: JavascriptMode.unrestricted,
//          ),
          Container(
            width: 200,height: 200,
            color: Colors.greenAccent,
            alignment: Alignment.center,
            child: getAndroidTextView(),
          ),
          Container(
            width: size.width,height: size.height/2,
            color: Colors.lightBlue,
          ),
        ],
      ),
    );
  }

  final url = "https://www.baidu.com";
//  Widget justWeb(Size size){
//    return WebView(
//      initialUrl: url,
//      javascriptMode: JavascriptMode.unrestricted,
//    );
//  }
  Widget justWebP(Size size){
    return WebviewScaffold(
      url: url,
      withJavascript: true,
    );
  }
}
