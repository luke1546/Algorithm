# [Platinum III] 팰린드롬 제거 - 30400 

[문제 링크](https://www.acmicpc.net/problem/30400) 

### 성능 요약

메모리: 34076 KB, 시간: 244 ms

### 분류

그리디 알고리즘, 매내처, 문자열

### 제출 일자

2024년 2월 26일 22:21:32

### 문제 설명

<p>이안이는 팰린드롬을 싫어한다. 팰린드롬인 단어를 보면 당장 그 단어를 지워야 할 정도로 팰린드롬을 매우 싫어한다. 팰린드롬은 '<code>level</code>', '<code>bob</code>'과 같이 양쪽으로 읽었을 때 동일하게 읽히는 단어이다.</p>

<p>이제 이안이는 팰린드롬이 아닌 단어더라도 부분문자열 중 팰린드롬이 있기만 해도 그 단어를 지우고 싶을 정도가 되었다. 하지만 그렇게 하면 남는 단어가 거의 없을 것이다. 대신 글자 몇 개를 부숴 길이가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container> 이상인 팰린드롬인 부분문자열이 없도록 만들려고 한다.</p>

<p>글자를 부수면 부서진 글자가 포함된 문자열은 팰린드롬이 될 수 없다. 예를 들어 <code>abcba</code>에서 가운데 <code>c</code>를 부수면 <code>ab#ba</code>가 되고, 이는 팰린드롬이 아니다.</p>

<p><code>banana</code>는 부분문자열 중 <code>anana</code>, <code>ana</code>, <code>nan</code>이 팰린드롬이므로 글자를 부숴야 한다. <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c3D"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi><mo>=</mo><mn>2</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M = 2$</span></mjx-container>인 경우 두 번째 <code>a</code>를 부수면 <code>ban#na</code>와 같이 길이가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$2$</span></mjx-container> 이상인 팰린드롬인 부분문자열이 없도록 할 수 있다.</p>

<p>글자를 부수는 건 매우 귀찮은 일이다. 이안이를 도와 부숴야 하는 글자 개수의 최솟값을 구해보자.</p>

### 입력 

 <p>첫 번째 줄에 단어의 길이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>, 싫어하는 팰린드롬의 길이인 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container>이 공백으로 구분되어 주어진다.</p>

<p>두 번째 줄에 길이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>인 단어가 한 줄에 주어진다.</p>

### 출력 

 <p>길이가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D440 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>M</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$M$</span></mjx-container> 이상인 팰린드롬인 부분문자열이 없도록 만들기 위해 부숴야 하는 글자 개수의 최솟값을 출력한다.</p>

