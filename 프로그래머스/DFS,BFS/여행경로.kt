class Solution {

    lateinit var check:BooleanArray
    lateinit var ticketArray:Array<Array<String>>
    var minAnswer = ""

    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = mutableListOf<String>()
        ticketArray = tickets
        check = BooleanArray(tickets.size)

        for(i in 0..tickets.lastIndex){
            if(tickets[i][0] == "ICN") {
                check[i] = true
                dfs(tickets[i][1],tickets[i][0]+tickets[i][1])
                check[i] = false
            }
        }

        for(i in 0..minAnswer.lastIndex step 3){
            var temp = "${minAnswer[i]}${minAnswer[i+1]}${minAnswer[i+2]}"
            answer.add(temp)
        }
        print("answer $minAnswer")
        return answer.toTypedArray()
    }

    fun dfs(start: String, now: String){

        if(!check.contains(false)){
            println(now)
            if(minPath(minAnswer,now))
                minAnswer = now
        }
        for(i in 0..ticketArray.lastIndex){
            if(ticketArray[i][0] == start && !check[i]){
                check[i] = true
                dfs(ticketArray[i][1], now+ticketArray[i][1])
                check[i] = false
            }
        }
    }

    fun minPath(first: String, second: String): Boolean{
        if(first == ""){
            return true
        }

        for(i in 0..first.lastIndex){
            if(first[i] < second[i])
                return false
            if(first[i] > second[i])
                return true
        }

        return true
    }
}

fun main(){
    var sol = Solution()
    var result1= sol.solution(arrayOf(arrayOf("ICN","SFO"),arrayOf("ICN","ATL"),arrayOf("SFO","ATL"),
            arrayOf("ATL","ICN"),arrayOf("ATL","SFO")))
//    var result2= sol.solution(arrayOf(arrayOf("ICN","JFK"),arrayOf("HND","IAD"),arrayOf("JFK","HND")))
    print(result1)
//    print(result2)
}