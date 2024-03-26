function solution(book_time) {
    let arr = []
    let room = new Map()
    let answer = []
    book_time.forEach((n,i)=>{
        let sTime = n[0].split(":")
        let start = parseInt(sTime[0])*60 + parseInt(sTime[1])
        let eTime = n[1].split(":")
        let end = parseInt(eTime[0])*60 + parseInt(eTime[1])
        arr.push([start, end])
    })
    arr = arr.sort((o1,o2) => o1[0]-o2[0])
        // console.log(arr)
    for(let i=0; i<arr.length; i++){
        let j=1;
        while(true){
            if(!(room.get(j) > arr[i][0]))  {
                room.set(j,arr[i][1] + 10)
                break
            }
            j++
        }
    }
    for(let key of room){
        answer.push(key[0])
    }
    return answer[answer.length-1]
}