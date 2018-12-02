%Definimos o membro a 1 como positivo, caso nao seja retorna 0
function count = isMemberCounterFilter(fi, bloom, k, n)
  count=0;
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
        vetor = zeros(1,k);
        res=0;
       	for i = 1:k
          	str = [str num2str(i)];
          	vetor(i) = mod((string2hash(str)), n)+1; 
        endfor  
        if all(bloom(vetor) == 1)
          	count+=1;
            printf("%s => %d\n", str, count);
        endif 
      endwhile
  endwhile  
end
