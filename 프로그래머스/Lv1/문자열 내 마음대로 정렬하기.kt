class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = arrayOf<String>()

        answer = strings.sortedWith(Comparator { o1, o2 ->
            if(o1[n] == o2[n]){
                return@Comparator o1.compareTo(o2)
            }
            else{
                return@Comparator o1[n] - o2[n]
            }

        }).toTypedArray()
//        answer = answer.sortedWith(compareBy({it[n]},{it})).toTypedArray()
        return answer
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution(arrayOf("sun","bed","car"),1)

    print(result)
}