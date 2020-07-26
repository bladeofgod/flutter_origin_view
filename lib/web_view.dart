


import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

class WebViewG extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return WebViewGState();
  }

}

class WebViewGState extends State<WebViewG> {
  @override
  Widget build(BuildContext context) {
    final size = MediaQuery.of(context).size;
    return Material(
      child: Container(
        width: size.width,height: size.height,
        child: justWeb(size),
      ),
    );
  }
  final url = "https://www.zhihu.com/";
  Widget justWeb(Size size){
    return WebView(
      initialUrl: url,
      javascriptMode: JavascriptMode.unrestricted,
    );
  }
}



















