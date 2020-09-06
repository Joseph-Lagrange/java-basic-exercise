import java.util.List;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "";
        String secondWordList = "";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        List<String> firstList = Arrays.asList(firstWordList.toUpperCase().split(","));
        List<String> secondList = Arrays.asList(secondWordList.toUpperCase().split(","));

        Stream.concat(firstList.stream(), secondList.stream())
                .collect(Collectors.toList())
                .forEach(item -> {
                    if (!item.matches("[a-zA-Z]+"))
                        throw new RuntimeException("input not valid");
                });

        List<String> list = firstList.stream()
                .distinct()
                .filter(secondList::contains)
                .collect(Collectors.toList());
        list.sort(String.CASE_INSENSITIVE_ORDER);

        List<String> result = new ArrayList<>(list.size());
        list.forEach(item -> result.add(item.replace("", " ").trim()));
        return result;
    }
}
