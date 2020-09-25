class Solution {
    fun solution(s: String): String {
        var answer = ""
        var arr = s.split(" ")
        var intArr = Array<Int>(arr.size, { i->0 })

        arr.forEachIndexed { index, s ->
            intArr[index] = s.toInt()
        }

        answer += intArr.min().toString() + " " + intArr.max().toString()

        return answer
    }
}

//class Solution {
//    fun solution(s: String): String = s.split(" ").map { it.toInt() }.let { "${it.min()} ${it.max()}" }
//}


fun main() {
    var sol = Solution()

    var result = sol.solution("1 2 3 4")

    print(result)
}