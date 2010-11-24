Validadores para a JSR303 (Bean Validator) no domínio brasileiro. Há implementações para CEP, CPF, CNPJ e Telefones no formato brasileiro.

Para utilizar basta adicionar o jar jsr303-br.jar no classpath de sua aplicação e anotar seus beans conforme:

Valida se o CPF é válido usando formatação, exemplo 000.000.000-00.

	@CPF(formatted = true)
	public String cpf;

Valida se o CPF é válido sem formatação, exemplo 00000000000.

	@CPF(formatted = false)
	public String cpf;

Mensagens

As mensagens são internacionalizadas através das chaves:
{telefone.error} - para as violações de telefone
{cpf.error} - para as violações de CPF
{cnpj.error} - para as violações de CNPJ
{cep.error} - para as violações de CEP

Basta adicionar essas chaves em seu arquivo ValidationMessages.properties, que deve estar no classpath da aplicação com as mensagens de sua preferência.

Para mais informações visite: http://people.redhat.com/~ebernard/validation