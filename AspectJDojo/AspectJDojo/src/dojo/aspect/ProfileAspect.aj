package dojo.aspect;

import java.util.HashMap;
import java.util.Map;
import dojo.test.*;

public aspect ProfileAspect {

	pointcut todosOsMetodosChamados() : !within(ProfileAspect) && call(* *.*(..));
	
	pointcut todosOsMetodosExecutados() : !within(ProfileAspect) && !within(FrontControlTest) && execution(* *.*(..));
	
	pointcut testeUnitario() : execution(* FrontControlTest.test*(..));
		
	private Map<String, Integer> contadorMetodosChamados = new HashMap<String, Integer>();
	
	//Contagem de metodos
	before() : todosOsMetodosChamados() {
		// System.out.println("Metodo chamado: " + thisJoinPoint.getSignature().getName());
		String metodoChamado = thisJoinPoint.getSignature().getName();
		if (contadorMetodosChamados.containsKey(metodoChamado)) {
			contadorMetodosChamados.put(metodoChamado, contadorMetodosChamados.get(metodoChamado).intValue() + 1);
		} else {
			contadorMetodosChamados.put(metodoChamado, 1);
		}
		
		
	}

	//Cronometro da chamada dos metodos
	Object around() : todosOsMetodosExecutados() {
		System.out.println(thisJoinPoint.getSignature().getName());
		long tempoInicial = System.currentTimeMillis();
		Object o = proceed();
		long tempoDeExecucao = System.currentTimeMillis() - tempoInicial;
		System.out.println("Tempo de Execução: " + tempoDeExecucao);
		return o;
	}
	
	after(): testeUnitario(){
		System.out.println("contador de metodos chamados: " + contadorMetodosChamados);
	}
}
