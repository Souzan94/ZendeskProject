package com.system.ZenDesk.Widget.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class EmailTemplate {


public String template;

public EmailTemplate(String templateId){

try{


    this.template=templateId;
}

catch(Exception e ){


    this.template="Find Your Code";
}

}

public String loadTemplate(String templateId) throws Exception {

ClassLoader classLoader = getClass().getClassLoader();
File file =new File(classLoader.getResource(templateId).getFile());
String content=" Find Your File";
try{
    content=new String(Files.readAllBytes(file.toPath()));

}


catch (IOException e){

    throw  new Exception("Couldnt Read Template With Id :"+templateId);

}

return content;

}

public  String getTemplate(Map<String,String> replacements){

String template=this.template;
for(Map.Entry<String,String> entry :replacements.entrySet()){
    template=template.replace("{{" + entry.getValue() + "}}",entry.getValue());

}
return template;
}



}
