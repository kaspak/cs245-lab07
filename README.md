# cs245-lab07

## Explanation of Code:
- create a hashmap to store <b>keys (judge candidates) and values (number of people who trust the candidate)</b>

- loop through pairs of given trust array:
  - If a candidate is <i>found trusting someone</i>, <b>the candidate is no longer valid and will be removed from hashmap</b>
  - if a candidate has <i>not been added to the hashmap</i>, <b>create a new key and increment the value to 1</b>
  - if a candidate is <i>being trusted by someone</i>, <b>increment the candidate's value</b>
  
- After the loop collects candidates, __there should only be one remaining candidate__,    
  - if the _size of the hashmap is not 1_, __return -1__
  - if the _only candidate does not have N-1 trustees_, __return -1__
  - if the _only candidate does have N-1 trustees_, __return the key (judge ID)__
  
## Output:
<img src="https://raw.githubusercontent.com/kaspak/cs245-lab07/main/Screen%20Shot%202020-11-12%20at%2011.15.32%20PM.png" height="400">
