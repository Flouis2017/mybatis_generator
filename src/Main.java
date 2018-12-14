public class Main {

    public static void main(String[] args) {
        String str = "sys_acl,sys_acl_module,sys_dept,sys_log,sys_role,sys_role_acl,sys_role_user,sys_user";
        String[] tbNameArr = str.split(",");
        String[] classNameArr = getClassName(str.split(","));
        for (String x : classNameArr){
            System.out.print(x + " ");
        }
        System.out.println("\n");

        StringBuffer sb = new StringBuffer();
        sb.setLength(0);
        for (int i = 0; i < tbNameArr.length; i++){
            sb.append("<table tableName=\""+tbNameArr[i]+"\" domainObjectName=\""+classNameArr[i]+"\" \n")
                    .append("\t\tenableCountByExample=\"false\" enableUpdateByExample=\"false\" \n")
                    .append("\t\tenableDeleteByExample=\"false\" enableSelectByExample=\"false\" \n")
                    .append("\t\tselectByExampleQueryId=\"false\"> \n")
                    .append("</table>\n\n");
        }
        System.out.println(sb.toString());
    }

    public static String[] getClassName(String[] argArr){
        String[] resArr = new String[argArr.length];
        for (int i = 0; i < argArr.length; i++){
            argArr[i] = underlineToHump(argArr[i]);
            argArr[i] = toUpperCaseFirstOne(argArr[i]);
            resArr[i] = argArr[i];
        }
        return resArr;
    }


    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0))){
            return s;
        }
        return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static String underlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

}
