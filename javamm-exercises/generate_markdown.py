import os

JAVA_FILES_ROOT = 'javamm-exercises\src\main\java\com\github\lorenzoyang'

solution_markers = {"begin": "#solution:begin", "end": "#solution:end"}
alternative_solution_markers = {
    "begin": "#alternativesolution:begin", "end": "#alternativesolution:end"}


def get_java_files(directory):
    """
    Get a list of Java files in the specified directory and its subdirectories.

    Args:
        directory (str): The directory to search for Java files.

    Returns:
        list: A list of file paths to Java files found in the directory and its subdirectories.
    """

    java_files = []
    # Walk through the directory tree
    for root, dirs, files in os.walk(directory):
        for file in files:
            # Check if the file has a .java extension
            if file.endswith('.java'):
                # Construct the full path of the Java file
                java_file_path = os.path.join(root, file)
                # Add the path to the list of Java files
                java_files.append(java_file_path)
    return java_files


def remove_four_spaces_from_beginning_of_one_line(line):
    """
    Removes four spaces from the beginning of a line.

    Args:
        line (str): The line to remove the spaces from.

    Returns:
        str: The line with four spaces removed from the beginning.
    """

    if line.startswith("    "):
        return line[4:]
    return line


def extract_solution_code(file_path, start_marker, end_marker):
    """
    Extracts the solution code from a file between the start_marker and end_marker.

    Args:
        file_path (str): The path to the file.
        start_marker (str): The marker indicating the start of the solution code.
        end_marker (str): The marker indicating the end of the solution code.

    Returns:
        str: The extracted solution code as a string.
    """

    code_lines = []
    inside_solution = False

    with open(file_path, 'r') as file:
        for line in file:
            if start_marker in line:
                inside_solution = True
                continue
            elif end_marker in line:
                inside_solution = False
                break
            elif inside_solution:
                line = remove_four_spaces_from_beginning_of_one_line(line)
                code_lines.append(line.rstrip())

    return '\n'.join(code_lines)


def extract_alternative_solutions_code(file_path, start_marker, end_marker, comment_marker):
    """
    Extracts alternative solutions code from a file.

    Args:
        file_path (str): The path to the file.
        start_marker (str): The marker indicating the start of a solution.
        end_marker (str): The marker indicating the end of a solution.
        comment_marker (str): The marker indicating a comment within a solution.

    Returns:
        list: A list of tuples containing the extracted code lines and comments.
              Each tuple consists of a string representing the code lines and a string representing the comment.
    """

    alternative_solutions = []
    inside_solution = False
    code_lines = []
    comment = None

    with open(file_path, 'r') as file:
        for line in file:
            if start_marker in line:
                inside_solution = True
                code_lines = []
                continue
            elif end_marker in line:
                inside_solution = False
                alternative_solutions.append((comment, '\n'.join(code_lines)))
                comment = None
                code_lines = []
                continue
            elif comment_marker in line and inside_solution:
                comment = "**" + "Soluzione alternativa: " + line.strip().replace("#comment:",
                                                                                  "").lstrip("//").strip()+"**"
                continue
            elif inside_solution and comment_marker not in line:
                line = remove_four_spaces_from_beginning_of_one_line(line)
                code_lines.append(line.rstrip())

    return alternative_solutions


def generate_markdowns():
    """
    Generate Markdown files from Java files.

    This function extracts solution code and alternative solutions from Java files,
    and creates corresponding Markdown files with the extracted code.

    Args:
        None

    Returns:
        None
    """
    java_files = get_java_files(JAVA_FILES_ROOT)

    for file_path in java_files:
        # Extract solution code
        solution_code = extract_solution_code(
            file_path, solution_markers["begin"], solution_markers["end"])
        # Extract alternative solutions
        alternative_solutions = extract_alternative_solutions_code(file_path,
                                                                   alternative_solution_markers["begin"],
                                                                   alternative_solution_markers["end"],
                                                                   comment_marker="#comment:")

        # Create Markdown file
        markdown_file_path = os.path.splitext(file_path)[0] + '.md'
        with open(markdown_file_path, 'w') as markdown_file:
            # Write solution code
            markdown_file.write("```java\n")
            markdown_file.write(solution_code)
            markdown_file.write("\n```")
            # Write alternative solutions
            for comment, alt_solution in alternative_solutions:
                markdown_file.write("\n\n")
                if comment:
                    markdown_file.write(comment + "\n")
                markdown_file.write("```java\n")
                markdown_file.write(alt_solution)
                markdown_file.write("\n```")


generate_markdowns()
