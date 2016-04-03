import java.util.ArrayList;

/**
 * Created by yuryc on 02.04.2016.
 */
public class NumericRelation {
    public static void main(String[] args) {
        String input=new String();
        ArrayList<String> inputList = new ArrayList<String>();
        ArrayList<StringBuffer> resultList = new ArrayList<StringBuffer>();

        StdOut.println("Введите пары чисел формата <a b> такие, что b зависит от a. После ввода пар нажмите на клавишу Enter:");

        do
        {
            input=StdIn.readLine();
            inputList.add(input);
        }while(!input.equals(""));
        inputList.remove(inputList.size()-1);

        String[] inputArray = {}; // конвертируем ArrayList в массив
        inputArray = inputList.toArray(new String[inputList.size()]);

        for(int i=0; i<inputList.size(); i++)
        {
            for(int j=i+1;j<inputList.size();j++)
            {
                if(inputArray[j].startsWith(Character.toString(inputArray[i].charAt(2))))
                    {
                        if(resultList.size()>0)
                        {
                            for (int k = 0; k < resultList.size(); k++)
                            {
                                if (resultList.get(k).toString().contains(inputArray[i])) {
                                    resultList.get(k).append(' ');
                                    resultList.get(k).append(inputArray[j].charAt(2));
                                } else {
                                    resultList.add(new StringBuffer(inputArray[i] + ' ' + inputArray[j].charAt(2)));
                                    break;
                                }
                            }
                        }else {
                            resultList.add(new StringBuffer(inputArray[i] + ' ' + inputArray[j].charAt(2)));
                        }
                    }
            }
        }
        for(int i=0;i<resultList.size();i++)
        {
            if(resultList.get(i).toString().endsWith(Character.toString(resultList.get(i).charAt(0))))
            StdOut.println(resultList.get(i));
        }
    }
}
