package com.github.finder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    private Args args;

    public Finder(Args args){
        this.args = args;
    }

    public String[] find(String target){
        List<String> list = new ArrayList<>();

        traverse(list, new File(target));

        return list.toArray(new String[list.size()]);
    }

   // private boolean isTarget(File file){
   //   return true;
   //}

    private boolean isTarget(File file){
        boolean flag = true;
        if(args.getName() != null){
            flag &= checkTargetName(file, args.getName());
        }
        return flag;
    }
    private boolean checkTargetName(File file, String pattern){
        String name = file.getName();
        return name.indexOf(pattern) >= 0;
    }


    private void traverse(List<String> list, File dir){
        if(isTarget(dir)){
            list.add(dir.getPath());
        }
        if(dir.isDirectory()){
            for(File file: dir.listFiles()){
                traverse(list, file);
            }
        }
    }
}
