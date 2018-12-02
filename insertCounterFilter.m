function bloom = insertCounterFilter(fi,bloom,k,n)
	while true;
		linha = fgetl(fi);
  		if linha == -1
        str = randomWord(5); %so para nao haver bugs
    		break
  		endif
  		remain = linha;
  		while length(remain) > 0
    		[str, remain] = strtok(remain, ' ,;.-');
    		if strcmp(remain, "uma")==1
      			printf("uma => %d", i);
    		endif
   		endwhile
      
    for i=1:k
		  str = [str num2str(i)];
		  tmp = mod((string2hash(str)),n)+1;
		  bloom(tmp)+=1;
    endfor
  endwhile
endfunction
