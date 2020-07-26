


import 'package:flutter/material.dart';
import 'package:flutter_webview_plugin/flutter_webview_plugin.dart';

class WebViewC extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return WebViewCState();
  }

}

class WebViewCState extends State<WebViewC> {
  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Material(
      child: Container(
        width: size.width,height: size.height,
        child:justWebP(size) ,
      ),
    );
  }
  final url = "https://www.zhihu.com/";
  Widget justWebP(Size size){
    return WebviewScaffold(
      url: url,
      withJavascript: true,
    );
  }
}
