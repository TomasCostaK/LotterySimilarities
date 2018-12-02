%Funçao usada no guiao anterior

function hash = string2hash(str)
  	hash = 5381*ones(size(str,1),1);
	for i=1:size(str,2)
    	hash = mod(hash*33 + str(:,i), 2^31 -1);
  	end
endfunction