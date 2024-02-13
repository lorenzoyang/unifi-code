import os


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
                code_lines.append(line.rstrip())

    return '\n'.join(code_lines)


if __name__ == '__main__':
    # print current . directory
    print(os.getcwd())

    solution_begin_marker = '// #solution:begin'
    solution_end_marker = '// #solution:end'
    java_files_root = 'javamm-exercises\src\main\java\com\github\lorenzoyang'

    # Get the list of Java files
    java_files = get_java_files(java_files_root)

    # Iterate over the Java files
    for file in java_files:
        print(file)
        # Extract the solution code from the Java file
        solution_code = extract_solution_code(
            file, solution_begin_marker, solution_end_marker)

        # Print the solution code
        print(solution_code)
        print()
        print('-' * 50)
        print()
