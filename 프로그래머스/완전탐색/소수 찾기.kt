class Solution {
    lateinit var string: String
    lateinit var check: BooleanArray
    val answerSet = mutableSetOf<Int>()

    fun solution(numbers: String): Int {
        string = numbers
        check = BooleanArray(string.length)
        permutation(0,"")

        return answerSet.size
    }

    fun permutation(depth: Int, makeStr: String){
        if(depth == string.length){
            if(makeStr.equals("")) return
            if(isPrime(makeStr.toInt())){
                println(makeStr.toInt())
                answerSet.add(makeStr.toInt())
            }
            return
        }

        for(i in 0..string.length-1){
            if(!check[i]) {
                check[i] = true
                permutation(depth + 1, makeStr + string[i])
                check[i] = false
                permutation(depth + 1, makeStr)
            }
        }
    }

    fun isPrime(number: Int): Boolean{

        for(i in 2..number-2){
            if(number%i == 0){
                return false
            }
        }
        if(number <= 1) return false

        return true
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution("011")

    print(result)
}