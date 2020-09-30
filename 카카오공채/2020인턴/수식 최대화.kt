class Solution {
    fun solution(expression: String): Long {
        var answer: Long = 0
        var numList = mutableListOf<Long>()
        var calcList = mutableListOf<Char>()
        var point = 0
        var sets = arrayOf(arrayOf('*','+','-'),arrayOf('*','-','+'),arrayOf('+','*','-')
                ,arrayOf('+','-','*'),arrayOf('-','+','*'),arrayOf('-','*','+'))

        for(i in 0..expression.lastIndex){
            if(expression[i] == '+'||expression[i] == '-'||expression[i] == '*'){
                numList.add(expression.substring(point..i-1).toLong())
                calcList.add(expression[i])
                point = i+1
            }
            if(i == expression.lastIndex){
                numList.add(expression.substring(point).toLong())
            }
        }

        for(set in sets) {
            var tempNumList = numList.toMutableList()
            var tempCalcList = calcList.toMutableList()
            for(oper in set){
                calc(tempNumList, tempCalcList, oper)
            }
            if (Math.abs(tempNumList[0]) > answer) answer = Math.abs(tempNumList[0])
        }

        return answer
    }

    fun calc(numList: MutableList<Long>, calcList: MutableList<Char>, oper: Char){
        var i = 0
        while(i < calcList.size){
            if(calcList[i] == oper){
                when(oper){
                    '*' -> numList[i] = numList[i] * numList[i+1]
                    '+' -> numList[i] = numList[i] + numList[i+1]
                    '-' -> numList[i] = numList[i] - numList[i+1]
                }
                numList.removeAt(i+1)
                calcList.removeAt(i)
                i--
            }
            i++
        }
    }
}

fun main() {
    var sol = Solution()

    var result = sol.solution("100-200*300-500+20")

    print(result)
}