## RICE-POT Prompt Framework

RICE-POT is a framework for creating clear and effective AI prompts.

| Component | Full Form | Purpose | Example |
|---|---|---|---|
| **R** | Role | Defines who the AI should act as | `Act as a Senior QA Automation Engineer.` |
| **I** | Instruction | Clearly describes what the AI needs to do | `Create Playwright test cases for the login functionality.` |
| **C** | Context | Provides relevant background information required to perform the task | `The application uses username, password, and MFA. Playwright with TypeScript and Jest is used.` |
| **E** | Example | Shows the AI the expected format, style, or type of response | `For each test case, provide Test ID, Preconditions, Steps, and Expected Result.` |
| **P** | Parameters | Defines constraints, rules, or specific requirements for the task | `Create 10 test cases. Use TypeScript and Jest expect assertions.` |
| **O** | Output | Specifies the desired output format | `Return the test cases in a Markdown table.` |
| **T** | Tone | Defines how the response should be written | `Keep the response concise and professional.` |


## Example

**Role:**  
Act as a Senior QA Automation Engineer.

**Instruction:**  
Create automated test scenarios for the login functionality.

**Context:**  
The application uses username/password authentication and MFA. Playwright with TypeScript and Jest is used.

**Example:**  
Each test case should contain Test ID, Preconditions, Steps, and Expected Result.

**Parameters:**  
Create 10 scenarios covering positive, negative, and edge cases. Use Jest `expect` assertions.

**Output:**  
Return the test cases in a Markdown table.

**Tone:**  
Keep the language concise and professional.


R → Who should AI be?

I → What should AI do?

C → What does AI need to know?

E → What should the response look like?

P → What rules/constraints should it follow?

O → What format should it return?

T → How should it communicate?